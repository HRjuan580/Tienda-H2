package iesra.dawb.seguros

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun main() {
    val jdbcUrl = "jdbc:h2:./data/tienda"  
    val user = "sa"                        
    val password = ""                      

    var connection: Connection? = null

    try {
        connection = DriverManager.getConnection(jdbcUrl, user, password)
        println(" Conexión exitosa a la base de datos H2.")

        val statement = connection.createStatement()
        val resultSet = statement.executeQuery("SELECT 1 + 1 AS Resultado")
        while (resultSet.next()) {
            println("Resultado de prueba: ${resultSet.getInt("Resultado")}")
        }

    } catch (e: SQLException) {
        println(" Error al conectar con la base de datos: ${e.message}")
    } finally {
        try {
            connection?.close()
            println(" Conexión cerrada.")
        } catch (e: SQLException) {
            println(" Error al cerrar la conexión: ${e.message}")
        }
    }
}

