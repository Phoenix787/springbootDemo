var app=angular.module("springdemo", []);
app.controller("AppCtrl", function($scope, $http){
    $scope.websites=[];
    $http.get('http://localhost:8090/api/web').then(function(response){
        $scope.websites=response.data;

    });
});