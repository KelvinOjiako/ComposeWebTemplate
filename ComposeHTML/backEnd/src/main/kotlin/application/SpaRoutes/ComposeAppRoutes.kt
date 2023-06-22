package application.SpaRoutes

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.response.*


fun Application.composeAppRoutes(){
    routing {
        singlePageApplication {
            useResources = true
            filesPath = "jsFrontEnd/src/jsMain/resources"
            defaultPage = "index.html"
            ignoreFiles { it.endsWith(".txt") }
        }

        get("test"){
            call.respondText("The server is indeed working!!!!1 ;)")
        }
    }

}