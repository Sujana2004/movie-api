<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Movie</title>
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
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .nav { margin-bottom: 25px; }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin-right: 10px;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            border: none;
            cursor: pointer;
            font-size: 14px;
        }
        .btn-secondary { background: #6c757d; }
        .btn-success { background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%); }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #333;
        }
        .required { color: #dc3545; }
        input, textarea, select {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e9ecef;
            border-radius: 8px;
            font-size: 15px;
            transition: border-color 0.2s;
        }
        input:focus, textarea:focus, select:focus {
            outline: none;
            border-color: #667eea;
        }
        .error {
            color: #dc3545;
            font-size: 13px;
            margin-top: 5px;
        }
        .btn-container {
            text-align: center;
            margin-top: 30px;
        }
        .btn-container .btn {
            padding: 14px 30px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="nav">
            <a href="/web/" class="btn btn-secondary"> Home</a>
            <a href="/web/movies" class="btn btn-secondary"> All Movies</a>
        </div>
        
        <h1>+ Add New Movie</h1>
        
        <form:form action="/web/movies/add" method="post" modelAttribute="movie">
            
            <div class="form-group">
                <label>Title <span class="required">*</span></label>
                <form:input path="title" placeholder="Enter movie title"/>
                <form:errors path="title" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label>Description <span class="required">*</span></label>
                <form:textarea path="description" rows="3" placeholder="Enter movie description"/>
                <form:errors path="description" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label>Genre <span class="required">*</span></label>
                <form:select path="genre">
                    <form:option value="">-- Select Genre --</form:option>
                    <form:option value="Action">Action</form:option>
                    <form:option value="Comedy">Comedy</form:option>
                    <form:option value="Drama">Drama</form:option>
                    <form:option value="Sci-Fi">Sci-Fi</form:option>
                    <form:option value="Horror">Horror</form:option>
                    <form:option value="Romance">Romance</form:option>
                    <form:option value="Thriller">Thriller</form:option>
                </form:select>
                <form:errors path="genre" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label>Release Year <span class="required">*</span></label>
                <form:input path="releaseYear" type="number" placeholder="e.g., 2024"/>
                <form:errors path="releaseYear" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label>Rating (0-10)</label>
                <form:input path="rating" type="number" step="0.1" min="0" max="10" placeholder="e.g., 8.5"/>
                <form:errors path="rating" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label>Director <span class="required">*</span></label>
                <form:input path="director" placeholder="Enter director name"/>
                <form:errors path="director" cssClass="error"/>
            </div>
            
            <div class="form-group">
                <label>Duration (minutes)</label>
                <form:input path="durationMinutes" type="number" placeholder="e.g., 120"/>
                <form:errors path="durationMinutes" cssClass="error"/>
            </div>
            
            <div class="btn-container">
                <button type="submit" class="btn btn-success"> Save Movie</button>
                <a href="/web/movies" class="btn btn-secondary">Cancel</a>
            </div>
            
        </form:form>
    </div>
</body>
</html>