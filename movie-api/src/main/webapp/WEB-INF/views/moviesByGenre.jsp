<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${genre} Movies</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f5f5f5;
            padding: 30px;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
        }
        h1 { color: #333; margin-bottom: 20px; }
        .nav { margin-bottom: 25px; }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin-right: 10px;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }
        .btn-secondary { background: #6c757d; }
        .btn-info { background: #17a2b8; }
        .stats {
            display: inline-block;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 12px 25px;
            border-radius: 8px;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #eee;
        }
        th {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }
        tr:hover { background: #f8f9fa; }
        .rating { color: #f39c12; font-weight: bold; }
        .empty-message {
            text-align: center;
            padding: 60px;
            color: #666;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="nav">
            <a href="/web/" class="btn btn-secondary"> Home</a>
            <a href="/web/movies" class="btn btn-secondary"> All Movies</a>
            <a href="/web/movies/genre" class="btn btn-info"> All Genres</a>
        </div>
        
        <h1> ${genre} Movies</h1>
        
        <div class="stats">Found: <strong>${count}</strong> movie(s)</div>
        
        <c:if test="${empty movies}">
            <div class="empty-message">
                <h3>No ${genre} movies found!</h3>
                <p><a href="/web/movies/add">Add a movie</a></p>
            </div>
        </c:if>
        
        <c:if test="${not empty movies}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Year</th>
                        <th>Rating</th>
                        <th>Director</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${movies}" var="movie">
                        <tr>
                            <td>${movie.id}</td>
                            <td><strong>${movie.title}</strong></td>
                            <td>${movie.releaseYear}</td>
                            <td><span class="rating">⭐ ${movie.rating}</span></td>
                            <td>${movie.director}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>