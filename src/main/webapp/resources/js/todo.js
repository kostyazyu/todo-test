function TodoCtrl($scope,$http) {

  $scope.todos = [];
  $scope.filter = 'ALL';

  $scope.$watch('filter', function(filter) {
    var listHandle = $http.post('json/todo/list',{type: filter, sortField: "text", sortDirection: "ASC"});
    listHandle.success(function(data, status, headers, config){
      $scope.todos = data;
    });
    listHandle.error(function(data, status, headers, config){
      alert('error');
    });
  });

/*  $scope.$watch('$viewContentLoaded', function(){
    var listHandle = $http.get('json/todo/list');
    listHandle.success(function(data, status, headers, config){
      $scope.todos = data;
    });
    listHandle.error(function(data, status, headers, config){
      alert('error');
    });
  });*/

  $scope.addTodo = function() {

    var handle = $http.put('json/todo/create', {text: $scope.todoText, done:false} );
    handle.success(function(data, status, headers, config){
        $scope.todos.push(data);
        console.log(data);
    });
    handle.error(function(data, status, headers, config){
      alert('error');
    });
    $scope.todoText = '';
  };

  $scope.updateTodo = function(todo) {

    var handle = $http.post('json/todo/update', todo);
    handle.success(function(data, status, headers, config){
      console.log(todo + 'name changed');
    });
    handle.error(function(data, status, headers, config){
      alert('error update');
    });
  };

  $scope.toggle = function(todo) {

    var handle = $http.post('json/todo/toggle', todo);
    handle.success(function(data, status, headers, config){
      if(data){
        todo.done = data.done;
        console.log(todo + ' toggled');
      }else{
        alert('update not happened');
      }
    });
    handle.error(function(data, status, headers, config){
      alert('error toggle');
    });
  };
 
  $scope.del = function(todo) {
    var handle = $http.post('json/todo/delete', todo);
    handle.success(function(data, status, headers, config){
      var oldTodos = $scope.todos;
      $scope.todos = [];
      angular.forEach(oldTodos, function(currentTodo) {
        if (todo != currentTodo) $scope.todos.push(currentTodo);
      });
    });
    handle.error(function(data, status, headers, config){
      alert('error deleting');
    });

  };
  
}