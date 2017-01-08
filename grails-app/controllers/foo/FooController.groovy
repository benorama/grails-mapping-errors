package foo

class FooController {

    def index() {
    	//def i x 
    }

    def upload() {
    	def f = request.getFile('myFile')
	    if (f.empty) {
	        flash.message = 'file cannot be empty'
	        render(view: 'uploadForm')
	        return
	    }

	    //f.transferTo(new File('/some/local/dir/myfile.txt'))
	    //response.sendError(200, 'Done')
	    render 'Upload done'
	}

	def exception() {
    	throw new Exception("Foo went wrong")
    }
}

