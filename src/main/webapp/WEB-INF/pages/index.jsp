<%@ page contentType="text/html; charset=UTF-8" %>
<html ng-app>

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.28/angular.min.js"></script>
    <script src="resources/js/todo.js"></script>
    <link rel="stylesheet" href="resources/css/todo.css">
</head>
<body>

<div class="wrap">
    <h2>Список дел</h2>
    <div ng-controller="TodoCtrl">
        <input class="btn-primary populate-btn" type="submit" ng-click="populate()" value="Заполнить список">
        <form ng-submit="addTodo()">
            <input type="text" ng-model="todoText"  size="30"
                   placeholder="Введите новое дело">
            <input class="btn-primary" type="submit" value="Добавить">
        </form>


        <%--radio button filter--%>
        <form name = "filterform">
            <input type="radio" ng-model="filter" value="ALL" > Все
            <input type="radio" ng-model="filter" value="DONE"/> Выполненные
            <input type="radio" ng-model="filter" value="NOT_DONE"/> Не выполненные
        </form>
        <br/>
        <div class="table">
            <div class="table-row table-header">
                <div class="header-cell cell-1">Дело</div>
                <div class="header-cell cell-2">Выполнено</div>
                <div class="header-cell cell-3">Удалить</div>
            </div>
            <div class="table-row" ng-repeat="todo in todos">
                <div class="table-cell cell-1">
                    <div ng-hide="editorEnabled">
                        <span class="done-{{todo.done}}">{{todo.text}}</span>
                        <a class="pencil-link" href="#" ng-click="editorEnabled=!editorEnabled"></a>
                    </div>
                    <div ng-show="editorEnabled">
                        <form ng-submit="editorEnabled=!editorEnabled; updateTodo(todo)">
                            <input ng-model="todo.text" size="30">
                        </form>
                    </div>
                </div>
                <div class="table-cell cell-2">
                    <input type="checkbox" ng-model="todo.done" ng-click="toggle(todo)">
                </div>
                <div class="table-cell cell-3">
                    <a class="del-link" href="#" ng-click="del(todo)"></a>
                </div>
            </div>
        </div>
        <br/>
        <br/>

    </div>
</div>
</body>
</html>