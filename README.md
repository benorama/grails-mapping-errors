# Grails mapping error

## Description

This app use a more advanced mapping to handle exception with a controller (instead of default /error and /notFound views).

```groovy
"/"(view:"/index")
//"500"(view:'/error')
//"404"(view:'/notFound')
"500"(controller: 'errors', action:'error')
"404"(controller: 'errors', action:'notFound')
```

With the following `ErrorsController`:

```groovy
class ErrorsController {

    def error() {
        response.status = 500
        render 'ERROR'
    }

    def notFound() {
        response.status = 404
        render 'NOT FOUND'
    }
}
```

With basic errors, that can be tested with:

* `/foo/exception`
* or `/foo/notFound`

The errors controller is correcty called.

But with low level errors such as tomcat file upload limit, it generates an endless loop and crash the app. 

To reproduce the issue:

* `grails run-app`
* go to `/foo`
* upload a file bigger than 200Ko

It will generate an exception loop in GrailsExceptionResolver.

## Workaround

Use default mapping.