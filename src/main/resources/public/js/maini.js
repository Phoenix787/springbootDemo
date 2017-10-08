var app=angular.module("reCaptchaDemo", []);
app.controller("AppCtrl", function($scope, $http){
$scope.auth={}
$scope.sendForm = function(auth){
   $http({
       method: POST,
       url: "/register",
       data: $.param(auth),
       header:{"Content-Type" : "application/x-www-form-urlencoded" }

   });
}

//    $scope.websites=[];
//    $http.get('http://localhost:8090/api/web').then(function(response){
//        $scope.websites=response.data;
//
//    });
});