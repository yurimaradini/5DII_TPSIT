const express = require('express')
const app = express()
const lim = require("express-rate-limit")

const limiter = lim.rateLimit({
  windowMs: 1 * 60 * 1000, // 1 minutes
  max: 10, // limit each IP to 500 requests per windowMs
  message: async (request, response) => {
		return 'You can only make 10 requests every hour.'
	},
});

app.use(limiter);

