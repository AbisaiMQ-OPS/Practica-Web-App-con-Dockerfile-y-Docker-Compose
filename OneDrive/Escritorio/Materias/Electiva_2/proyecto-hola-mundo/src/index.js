// index.js - app simple express que se conecta a MySQL y responde Hola Mundo
const express = require('express');
const mysql = require('mysql2/promise');

const {
  DB_HOST = 'mysql',
  DB_USER = 'root',
  DB_PASSWORD = 'example',
  DB_NAME = 'hola_mundo',
  DB_PORT = 3306,
  PORT = 3000
} = process.env;

const app = express();
let dbConnection;

// función para intentar conectar con reintentos
async function connectWithRetry(retries = 15, delayMs = 2000) {
  for (let i = 0; i < retries; i++) {
    try {
      const conn = await mysql.createConnection({
        host: DB_HOST,
        user: DB_USER,
        password: DB_PASSWORD,
        database: DB_NAME,
        port: DB_PORT
      });
      console.log('✔ Conectado a MySQL');
      return conn;
    } catch (err) {
      console.log(`Esperando MySQL... intento ${i + 1}/${retries}. Error: ${err.code || err.message}`);
      await new Promise(res => setTimeout(res, delayMs));
    }
  }
  throw new Error('No se pudo conectar a MySQL después de varios intentos');
}

app.get('/', async (req, res) => {
  try {
    // consulta simple para demostrar conexion
    const [rows] = await dbConnection.execute('SELECT mensaje FROM mensaje LIMIT 1;');
    const mensaje = rows[0] ? rows[0].mensaje : 'Hola Mundo (sin datos)';
    res.send(`<h1>${mensaje}</h1><p>Conexión a BD: OK</p>`);
  } catch (err) {
    res.status(500).send(`<h1>Hola Mundo</h1><p>Error al consultar BD: ${err.message}</p>`);
  }
});

// iniciar servidor después de conectar
async function start() {
  try {
    dbConnection = await connectWithRetry();
    app.listen(PORT, () => {
      console.log(`App escuchando en http://0.0.0.0:${PORT}`);
    });
  } catch (err) {
    console.error('Error al iniciar la app:', err);
    process.exit(1);
  }
}

start();
