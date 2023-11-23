// Fetch tasks from the server and populate the table
function fetchTasks() {
    fetch('/dashboard/myTasks')
        .then(response => response.json())
        .then(tasks => {
            const table = document.getElementById('taskTable');
            tasks.forEach(task => {
                const row = table.insertRow();
                row.insertCell(0).textContent = task.id;
                row.insertCell(1).textContent = task.creator;
                row.insertCell(2).textContent = task.name;
                row.insertCell(3).textContent = task.description;
                row.insertCell(4).textContent = task.teammate1;
                row.insertCell(5).textContent = task.teammate2;
                row.insertCell(6).textContent = task.teammate3;
            });
        });
}

// Save a new task
function saveTask() {
    const form = document.getElementById('taskForm');
    const formData = new FormData(form);

    fetch('/dashboard/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(Object.fromEntries(formData)),
    })
        .then(response => response.json())
        .then(task => {
            // Clear the form
            form.reset();
            // Refresh the task table
            const table = document.getElementById('taskTable');
            table.innerHTML = '<tr><th>ID</th><th>Creator</th><th>Name</th><th>Description</th><th>Teammate 1</th><th>Teammate 2</th><th>Teammate 3</th></tr>';
            fetchTasks();
        });
}

function deleteTask() {
    const deleteForm = document.getElementById('deleteForm');
    const taskId = deleteForm.elements.taskId.value;

    fetch('/dashboard/delete?id=' + taskId, {
        method: 'DELETE',
    })
        .then(() => {
            // Refresh the task table
            const table = document.getElementById('taskTable');
            table.innerHTML = '<tr><th>ID</th><th>Creator</th><th>Name</th><th>Description</th><th>Teammate 1</th><th>Teammate 2</th><th>Teammate 3</th></tr>';
            fetchTasks();
        });
}
// Fetch tasks when the page loads
fetchTasks();
