angular.module("reCaptchaDemo").controller("AppCtrl", function($scope, $http){
$scope.auth={};
$scope.sendForm = function(auth){
   $http({
       method: "POST",
//       url: "/register",
       url: "http://localhost:8080/register",
       data: $.param(auth),
       headers: { "Content-Type" : "application/x-www-form-urlencoded; charset=utf-8" }

   }).then(
        function(data){
            window.alert("Успешно зарегистрирован")
        },
        function(error){
            window.alert("При регистрации произошла ошибка")
        }
   )
}
});