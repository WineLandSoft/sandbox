
// Use Parse.Cloud.define to define as many cloud functions as you want.
// For example:
Parse.Cloud.define("hello", function(request, response) {
  response.success("Hello world!");
});

Parse.Cloud.define("prueba", function(request, response) {
  var query = new Parse.Query("jeroglifico");
  //query.equalTo("movie", request.params.movie);
  query.limit(1);
  query.find({
    success: function(results) {
      response.success(JSON.stringify(results[0]));
    },
    error: function() {
      response.error("error al obtener un jeroglifico");
    }
  });
});
