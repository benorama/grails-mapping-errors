package foo

import grails.converters.JSON

class ErrorsController {

    def error() {
        response.status = 500
        //renderError('error')
        render 'ERROR'
    }

    def notFound() {
        response.status = 404
        //renderError('notFound')
        render 'NOT FOUND'
    }

    private def renderError(String view) {
    	def result = [code: response.status, message: params.message]
        withFormat {
            html { render view: "/error/${view}" }
            json { render result as JSON } //new ApiResponse(code: response.status, message: params.message)
        }
    }

}
