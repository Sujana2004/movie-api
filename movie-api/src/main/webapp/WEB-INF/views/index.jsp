<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movie API - Home</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 40px 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background: white;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
        }
        h1 {
            text-align: center;
            color: #333;
            font-size: 2.5em;
            margin-bottom: 10px;
        }
        .subtitle {
            text-align: center;
            color: #666;
            font-size: 1.2em;
            margin-bottom: 30px;
        }
        .stats {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            margin-bottom: 30px;
            font-size: 1.2em;
        }
        .stats strong { color: #667eea; }
        .btn-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 15px;
            margin-bottom: 40px;
        }
        .btn {
            display: block;
            padding: 20px;
            text-align: center;
            color: white;
            text-decoration: none;
            border-radius: 10px;
            font-size: 16px;
            font-weight: bold;
            transition: transform 0.2s, box-shadow 0.2s;
        }
        .btn:hover {
            transform: translateY(-3px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.2);
        }
        .btn-primary { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); }
        .btn-success { background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%); }
        .btn-info { background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%); }
        .btn-warning { background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%); }
        .api-section {
            background: #f8f9fa;
            padding: 25px;
            border-radius: 10px;
        }
        .api-section h3 {
            color: #333;
            margin-bottom: 15px;
            font-size: 1.3em;
        }
        .api-link {
            display: block;
            padding: 10px 0;
            color: #667eea;
            text-decoration: none;
            border-bottom: 1px solid #eee;
        }
        .api-link:hover { color: #764ba2; }
        .api-link:last-child { border-bottom: none; }
    </style>
</head>
<body>
    <div class="container">
        <h1>🎬 Movie API</h1>
        <p class="subtitle">${message}</p>
        
        <div class="stats">
            📊 Total Movies: <strong>${movieCount}</strong>
        </div>
        
        <div class="btn-grid">
            <a href="/web/movies" class="btn btn-primary">📋 View All Movies</a>
            <a href="/web/movies/add" class="btn btn-success">➕ Add New Movie</a>
            <a href="/web/movies/genre" class="btn btn-info">🎭 Browse by Genre</a>
            <a href="/web/movies/count" class="btn btn-warning">📊 Movie Statistics</a>
        </div>
        
        <div class="api-section">
            <h3>🔗 REST API Endpoints</h3>
            <a href="/api/movies" class="api-link">GET /api/movies - Get all movies</a>
            <a href="/api/movies/1" class="api-link">GET /api/movies/1 - Get movie by ID</a>
            <a href="/api/movies/genre/Sci-Fi" class="api-link">GET /api/movies/genre/Sci-Fi - Get by genre</a>
            <a href="/api/movies/count" class="api-link">GET /api/movies/count - Get movie count</a>
        </div>
    </div>
</body>
</html>