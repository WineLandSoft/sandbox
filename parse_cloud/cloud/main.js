
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

Parse.Cloud.define("test", function(request, response) {
	var user = Parse.User.current();
	var relation = user.relation("likes");
	relation.add(post);
	user.save();
	
	response.success("OK");
});

Parse.Cloud.define("averageStars", function(request, response) {
  var query = new Parse.Query("Review");
  query.equalTo("movie", request.params.movie);
  query.find({
    success: function(results) {
      var sum = 0;
      for (var i = 0; i < results.length; ++i) {
        sum += results[i].get("stars");
      }
      response.success(sum / results.length);
    },
    error: function() {
      response.error("movie lookup failed");
    }
  });
});

Parse.Cloud.define("getNuevoJeroglifico", function(request, response) {
	var user = Parse.User.current();
	
	response.success(JSON.stringify(user));
});
