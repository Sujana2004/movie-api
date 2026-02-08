<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Movies</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f5f5f5;
            padding: 30px;
        }
        .container {
            max-width: 1000px;
            margin: 0 auto;
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
        }
        h1 { color: #333; margin-bottom: 20px; }
        .nav {
            margin-bottom: 25px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin-right: 10px;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-size: 14px;
        }
        .btn-secondary { background: #6c757d; }
        .btn-success { background: #28a745; }
        .btn-info { background: #17a2b8; }
        .stats {
            display: inline-block;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 12px 25px;
            border-radius: 8px;
            margin-bottom: 20px;
            font-size: 16px;
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
            font-weight: 600;
        }
        tr:hover { background: #f8f9fa; }
        .rating { color: #f39c12; font-weight: bold; }
        .genre-badge {
            background: #e9ecef;
            padding: 5px 12px;
            border-radius: 20px;
            font-size: 12px;
            color: #495057;
            text-decoration: none;
        }
        .genre-badge:hover { background: #dee2e6; }
        .empty-message {
            text-align: center;
            padding: 60px;
            color: #666;
        }
        .empty-message h3 { margin-bottom: 15px; color: #333; }
    </style>
</head>
<body>
    <div class="container">
        <div class="nav">
            <a href="/web/" class="btn btn-secondary"> Home</a>
            <a href="/web/movies/add" class="btn btn-success">+ Add Movie</a>
            <a href="/web/movies/genre" class="btn btn-info"> By Genre</a>
        </div>
        
        <h1> All Movies</h1>
        
        <div class="stats"> Total: ${totalCount} movies</div>
        
        <c:if test="${empty movies}">
            <div class="empty-message">
                <h3>No movies found!</h3>
                <p><a href="/web/movies/add">Add your first movie</a></p>
            </div>
        </c:if>
        
        <c:if test="${not empty movies}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Genre</th>
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
                            <td>
                                <a href="/web/movies/genre/${movie.genre}" class="genre-badge">
                                    ${movie.genre}
                                </a>
                            </td>
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