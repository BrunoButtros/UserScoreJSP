<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Scores</title>
    <!-- Incluindo o CSS do Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
        window.onload = function() {
            // Parse the JSON string to an object
            var users = JSON.parse('${userScores}');

            // Get the tbody element where the table rows will be added
            var tbody = document.getElementById('userTableBody');

            // Iterate over the users and create table rows
            users.forEach(function(user) {
                var tr = document.createElement('tr');

                var tdName = document.createElement('td');
                tdName.textContent = user.nome;
                tr.appendChild(tdName);

                var tdScore = document.createElement('td');
                tdScore.textContent = user.score;
                tr.appendChild(tdScore);

                tbody.appendChild(tr);
            });
        };
    </script>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">User Scores</h2>
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Score</th>
                </tr>
            </thead>
            <tbody id="userTableBody">
                <!-- Rows will be inserted here by JavaScript -->
            </tbody>
        </table>
    </div>

    <!-- Incluindo o JavaScript do Bootstrap e dependências -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>