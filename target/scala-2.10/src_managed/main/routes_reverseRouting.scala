// @SOURCE:/home/khabat95/workspace/database-sample/conf/routes
// @HASH:3da3037f30ae475a692fb73a1e1322299e49b76c
// @DATE:Sun Mar 02 14:04:28 EST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseTables {
    

// @LINE:13
def deleteTable(name:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "tables/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)) + "/delete")
}
                                                

// @LINE:12
def newTable(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "tables")
}
                                                

// @LINE:14
def openTable(name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "table" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("name", name)))))
}
                                                

// @LINE:11
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "tables")
}
                                                
    
}
                          

// @LINE:17
class ReverseAssets {
    

// @LINE:17
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:9
def createAccount(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "createAccount")
}
                                                

// @LINE:10
def submitAccount(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "createAccount")
}
                                                

// @LINE:8
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:7
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseTables {
    

// @LINE:13
def deleteTable : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tables.deleteTable",
   """
      function(name) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tables/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name)) + "/delete"})
      }
   """
)
                        

// @LINE:12
def newTable : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tables.newTable",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tables"})
      }
   """
)
                        

// @LINE:14
def openTable : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tables.openTable",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "table" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("name", name)])})
      }
   """
)
                        

// @LINE:11
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tables.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tables"})
      }
   """
)
                        
    
}
              

// @LINE:17
class ReverseAssets {
    

// @LINE:17
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:9
def createAccount : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.createAccount",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createAccount"})
      }
   """
)
                        

// @LINE:10
def submitAccount : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.submitAccount",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createAccount"})
      }
   """
)
                        

// @LINE:8
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:17
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
class ReverseTables {
    

// @LINE:13
def deleteTable(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Tables]).deleteTable(name), HandlerDef(this, "controllers.Tables", "deleteTable", Seq(classOf[String]), "POST", """""", _prefix + """tables/$name<[^/]+>/delete""")
)
                      

// @LINE:12
def newTable(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Tables]).newTable(), HandlerDef(this, "controllers.Tables", "newTable", Seq(), "POST", """""", _prefix + """tables""")
)
                      

// @LINE:14
def openTable(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Tables]).openTable(name), HandlerDef(this, "controllers.Tables", "openTable", Seq(classOf[String]), "GET", """""", _prefix + """table""")
)
                      

// @LINE:11
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Tables]).index(), HandlerDef(this, "controllers.Tables", "index", Seq(), "GET", """""", _prefix + """tables""")
)
                      
    
}
                          

// @LINE:17
class ReverseAssets {
    

// @LINE:17
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:9
def createAccount(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).createAccount(), HandlerDef(this, "controllers.Application", "createAccount", Seq(), "GET", """""", _prefix + """createAccount""")
)
                      

// @LINE:10
def submitAccount(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).submitAccount(), HandlerDef(this, "controllers.Application", "submitAccount", Seq(), "POST", """""", _prefix + """createAccount""")
)
                      

// @LINE:8
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:7
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.Application]).login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      
    
}
                          
}
        
    