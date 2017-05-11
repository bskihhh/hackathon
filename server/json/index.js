
const data = {
	"tableId": 1,
	"server": {
		"serverId": 1,
		"serverName": "Bo"
	},
	"restaurant": {
		"restaurantId": 1,
		"restaurantName": "GOBO"
	},
	"order": {
		"orderId": "1",
		"items":[
			{
				"itemId": 1,
				"name": "Royale with Cheese",
				"price": {
					"amount": 10,
					"currency": "CAD"
				}
			},
			{
				"itemId": 2,
				"name": "Vanilla Shake",
				"price": {
					"amount": 10,
					"currency": "CAD"
				}
			}
		]
	},
	"customer": {
		"name": "Gordon",
		"id": 1
	}
}
exports = module.exports = data
