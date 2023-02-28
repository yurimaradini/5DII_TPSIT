// Per i moduli da installare potete trovarli o nella pagina del pachetto che utilizziamo (https://www.npmjs.com/package/sqlite)
// oppure potete vederli nel file package.json

import sqlite3 from 'sqlite3'
import { open } from 'sqlite'			//con questa sintassi posso importare solo la funzione che mi serve
import express from'express'			//riscrivo l'import di express con la nuova sintassi
import bodyParser from 'body-parser'


//abbiamo aperto una "connessione" al nostro db, che in questo caso è un file locale
const db = await open({
	filename: './sqlite.db',
	driver: sqlite3.Database
})

//creiamo le tabelle necessarie se non esistono già
await db.exec('CREATE TABLE IF NOT EXISTS prodotti (id INTEGER AUTOINCREMENT, nome varchar(40), prezzo DECIMAL DEFAULT 0.0, qta INTEGER DEFAULT 0, picture VARCHAR(200))')


const app = express()
const port = 3000

// usando body parser posso (come dice il nome) aggiungere supporto per il parsing di diversi tipi di body
app.use(bodyParser.json());		//parsing di JSON
//app.use(bodyParser.urlencoded({ extended: true }));		//parsing di dati in un url


//read
app.get('/products', async (req, res) => {
	try {
		const result = await db.all(`SELECT * FROM prodotti`);
		res.status(200).send(result);	
	} catch (error) {
		console.log(error);		//NOTA: non è una quasi mai una buona idea inviare l'errore così com'è perchè potrebbe esporre all'esterno come il database è internamente formato
		res.status(400).send({message: "Errore con la richiesta"});
	}
});

//create
app.put('/insert', async (req, res) => {
	// NOTA: body della richiesta di esempio: '{"message": "messaggio di esempio"}'
	const message = req.body.message;		// NOTA: req.body è undefined se non dichiariamo un modo per fare il parsing di JSON
	
	try {
		const _result = await db.run(`INSERT INTO prodotti VALUES ("${message}",)`);
		res.status(200).send({message: "OK"});
	} catch (error) {
		console.log(error);		//NOTA: non è una quasi mai una buona idea inviare l'errore così com'è perchè potrebbe esporre all'esterno come il database è internamente formato
		res.status(400).send({message: "Errore con la richiesta"});
	}
});

// NOTA: che operazioni CRUD mancano ?

app.listen(port, () => {
	console.log(`DB test app running at: http://localhost:${port}/message`)
});