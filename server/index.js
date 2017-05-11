const express = require ('express'),
	app   = express (),
	data  = require ('./json'),
	port  = 3000


/* table id: qr code extracted */

app.get ('/table/:tableId/checkout', (req, res) => {
	console.log ('got request...\nparams=', req.params)
	res.status (200).json (data)
})

app.post ('/table/:tableId/register', (req, res) => {
	let {userId} = req.body,
		{tableId} = req.params

	res.status (201).json ({tableId: 1, orderId: 1})
})

app.post ('/table/:tableId/pay', (req, res) => {
	let {userId, card, tipAmount} = req.body
	res.status (201).json ({status: "successful", orderId: 1})
})

app.listen (port, ()=>{
	console.log ("gobo is live @" + port )
})
