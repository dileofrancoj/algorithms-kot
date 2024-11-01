package org.example.designPatterns

enum class RequestType {
    PASSWORD_RESET,
    SOFTWARE_ISSUE,
    TECH_ISSUE
}

// internal hace que solo sea visible para las implementaciones y no desde la fn main
abstract class SupportHandler(internal val nextHandler: SupportHandler?) {
    abstract fun handleRequest(requestType: RequestType)
}

class BasicSupport(nextHandler: SupportHandler?): SupportHandler(nextHandler) {
    override fun handleRequest(requestType: RequestType) {
        when (requestType) {
            RequestType.PASSWORD_RESET -> {
                println("Soporte básico: Reiniciando password")
            }
            else -> {
                println("Soporte basico no pudo manejar esta solicitud...")
                nextHandler?.handleRequest(requestType)
            }
        }
    }
}

class AdvancedSupport(nextHandler: SupportHandler?): SupportHandler(nextHandler) {
    override fun handleRequest(requestType: RequestType) {
        when(requestType) {
            RequestType.SOFTWARE_ISSUE -> {
                println("Soporte avanzado: Resolviendo el problema de software")
            }
            else -> {
                println("Soporte avanzado no pudo manejar la solicitud:")
                nextHandler?.handleRequest(requestType)
            }
        }
    }
}

class DevelopmentSupport: SupportHandler(null) {
    override fun handleRequest(requestType: RequestType) {
        println("El equipo de desarrollo tomo la solicitud")
    }
}

fun demo() {
    val developmentSupport = DevelopmentSupport()
    val advancedSupport = AdvancedSupport(developmentSupport)
    val basicSupport = BasicSupport(advancedSupport)
    println("Inicio de solicitud: Reinicio de contraseña")
    basicSupport.handleRequest(RequestType.PASSWORD_RESET)

    println("Problema de software")
    basicSupport.handleRequest(RequestType.SOFTWARE_ISSUE)
}