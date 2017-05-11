'use strict'
const express = require ('express'),
	app   = express (),
	data  = require ('./json'),
	port  = process.env.PORT || 3000,
	uuid = require ('uuid/v4'),
	_ = require ('lodash'),
	bodyParser = require('body-parser')

app.use(bodyParser())

let orderIds = []

/* table id: qr code extracted */
let validateTableId = (tableId, callback) => {
	if (tableId != "1") callback ("table not found")
	else callback (null)
}

let validateOrderId = (orderId, callback) => {
	let found = _.find (orderIds, (_id) => {return _id === orderId})
	if (found === undefined) callback ("order not found")
	else callback (null)	
}

let checkout = (order, callback) => {
	validateOrderId (order.orderId, (err) => {
		if (err) {
			callback (err)
		} else {
			_.remove (orderIds, (_id) => {return _id === order.orderId})
			callback (null)
		}
	})
}

app.post ('/register', (req, res) => {
	let {tableId} = req.body
	validateTableId (tableId, (err) => {
		if (err) {
			console.log ("[err]\ncannot register table", tableId)
			console.log (err)
			res.status (404).end()
		} else {
			let orderId = uuid()
			orderIds.push (orderId)
			console.log ("[success]\nregistration successful for table", tableId)
			res.status (201).json ({orderId, tableId})
		}
	})
})

// create final bill, but rendered from stored json
app.post ('/checkout', (req, res) => {
	let {orderId} = req.body
	validateOrderId (orderId, (err) => {
		if (err) {
			console.log ("[err]\ncannot checkout for order", orderId)
			console.log (err)
			res.status (404).end()
		} else {
			console.log ("[success]\ncheckout successful for order", orderId)
			res.status (200).json (Object.assign (data, {order: {orderId, items: data.order.items}}))
		}
	})
})


app.post ('/pay', (req, res) => {
	let {card, totalAmount, orderId} = req.body
	checkout ({card, totalAmount, orderId}, (err) => {
		if (err) {
			console.log ("[err]\ncannot pay for order", orderId)
			console.log (err)
			res.status (400).end ()	
		} else {
			console.log ("[success]\npay successful for order ", orderId)
			res.status (201).end ()
		}
	})
})

app.listen (port , ()=>{
	console.log ("gobo is live @" + port )
})
