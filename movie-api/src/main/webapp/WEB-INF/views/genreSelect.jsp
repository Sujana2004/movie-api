<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Select Genre</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f5f5f5;
            padding: 30px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background: white;
            padding: 35px;
            border-radius: 15px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
            text-align: center;
        }
        h1 { color: #333; margin-bottom: 10px; }
        .nav { margin-bottom: 25px; text-align: left; }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin-right: 10px;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }
        .btn-secondary { background: #6c757d; }
        .stats {
            background: #f8f9fa;
            padding: 15px;
            border-radius: 8px;
            margin: 20px 0;
            font-size: 18px;
        }
        .genre-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 15px;
            margin-top: 25px;
        }
        .genre-btn {
            padding: 25px;
            color: white;
            text-decoration: none;
            border-radius: 12px;
            font-size: 18px;
            font-weight: bold;
            transition: transform 0.2s;
        }
        .genre-btn:hover { transform: scale(1.05); }
        .action { background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%); }
        .comedy { background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%); }
        .drama { background: linear-gradient(135deg, #43e97b 0%, #38f9d7 100%); }
        .scifi { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); }
        .horror { background: linear-gradient(135deg, #30cfd0 0%, #330867 100%); }
        .romance { background: linear-gradient(135deg, #ff9a9e 0%, #fecfef 100%); color: #333; }
        .thriller { background: linear-gradient(135deg, #a8edea 0%, #fed6e3 100%); color: #333; }
    </style>
</head>
<body>
    <div class="container">
        <div class="nav">
            <a href="/web/" class="btn btn-secondary">Home</a>
            <a href="/web/movies" class="btn btn-secondary">All Movies</a>
        </div>
        
        <h1>Browse by Genre</h1>
        
        <div class="stats">Total Movies: <strong>${totalCount}</strong></div>
        
        <div class="genre-grid">
            <a href="/web/movies/genre/Action" class="genre-btn action"> Action</a>
            <a href="/web/movies/genre/Comedy" class="genre-btn comedy"> Comedy</a>
            <a href="/web/movies/genre/Drama" class="genre-btn drama"> Drama</a>
            <a href="/web/movies/genre/Sci-Fi" class="genre-btn scifi"> Sci-Fi</a>
            <a href="/web/movies/genre/Horror" class="genre-btn horror"> Horror</a>
            <a href="/web/movies/genre/Romance" class="genre-btn romance"> Romance</a>
            <a href="/web/movies/genre/Thriller" class="genre-btn thriller"> Thriller</a>
        </div>
    </div>
</body>
</html>