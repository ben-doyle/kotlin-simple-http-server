import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.time.ZonedDateTime

fun main(args: Array<String>) {
    val portNumber = args[0].toInt()

    try {
        val socket = ServerSocket(portNumber).accept()
        val output = PrintWriter(socket.getOutputStream(), true)
        val input = BufferedReader(InputStreamReader(socket.getInputStream()))

        val firstLine = input.readLine().split(" ")
        val method = firstLine[0]
        val resource = firstLine[1]
        val httpVersion = firstLine[2]
        val now = ZonedDateTime.now()

        println("$now INFO: Method: $method, resource requested: $resource, HTTP Version: $httpVersion")

        while (input.readLine() !== null) {
            println(input.readLine())
        }
    } catch (ioe: IOException) {
        println("Couldn't open serverSocket " + ioe.message)
    }
}
