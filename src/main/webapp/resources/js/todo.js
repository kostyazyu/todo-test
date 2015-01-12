function TodoCtrl($scope,$http) {

  $scope.todos = [];
  $scope.filter = 'ALL';

  var filterFunction = function(filter) {
    var listHandle = $http.post('json/todo/list', {type: filter, sortField: "id", sortDirection: "ASC"});
    listHandle.success(function (data, status, headers, config) {
      $scope.todos = data;
    });
    listHandle.error(function (data, status, headers, config) {
      alert('error');
    });
  }

  $scope.$watch('filter', filterFunction);

  $scope.addTodo = function() {

    var handle = $http.put('json/todo/create', {text: $scope.todoText, done:false} );
    handle.success(function(data, status, headers, config){
      filterFunction($scope.filter);
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
      filterFunction($scope.filter);
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
        filterFunction($scope.filter);
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

  $scope.populate = function(){
    var handle = $http.get('json/todo/populate');
    handle.success(function(data, status, headers, config){
      filterFunction($scope.filter);
      console.log('base populated');
    });
    handle.error(function(data, status, headers, config){
      alert('error populating');
    });
  };
  
}