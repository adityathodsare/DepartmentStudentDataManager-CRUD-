const apiUrl = 'http://localhost:8080/api/students';

// Add Student or Update Student
document.getElementById('studentForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const updateId = document.getElementById('updateStudentId').value;

    if (updateId) {
        // If there's an updateId, call the updateStudent function
        updateStudent(Number(updateId)); // Convert updateId to number
    } else {
        // Otherwise, add a new student
        const studentData = {
            firstName: document.getElementById('firstName').value,
            lastName: document.getElementById('lastName').value,
            yearOfStudy: document.getElementById('yearOfStudy').value,
            phoneNo: document.getElementById('phoneNo').value,
            email: document.getElementById('email').value,
            address: document.getElementById('address').value,
            electiveSub1: document.getElementById('electiveSub1').value,
            electiveSub2: document.getElementById('electiveSub2').value,
            cgpa1: document.getElementById('cgpa1').value,
            cgpa2: document.getElementById('cgpa2').value,
            cgpa3: document.getElementById('cgpa3').value,
            cgpa4: document.getElementById('cgpa4').value
        };

        fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(studentData),
        })
        .then(response => response.json())
        .then(data => {
            alert('Student added successfully!');
            document.getElementById('studentForm').reset();
            getAllStudents(); // Refresh student list after adding
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }
});

// Fetch All Students
function getAllStudents() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(students => {
            displayStudents(students);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Display Students
function displayStudents(students) {
    const studentsDisplay = document.getElementById('studentsDisplay');
    studentsDisplay.innerHTML = '';

    if (students.length === 0) {
        studentsDisplay.innerHTML = '<p>No students found.</p>';
        return;
    }

    const ul = document.createElement('ul');

    students.forEach(student => {
        const li = document.createElement('li');
        li.textContent = `${student.firstName} ${student.lastName} (${student.yearOfStudy})`;

        // Create Edit button
        const editButton = document.createElement('button');
        editButton.textContent = 'Edit';
        editButton.onclick = () => editStudent(student.id);
        li.appendChild(editButton);

        // Create Delete button
        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.onclick = () => deleteStudent(student.id);
        li.appendChild(deleteButton);

        ul.appendChild(li);
    });

    studentsDisplay.appendChild(ul);
}

// Edit Student
function editStudent(id) {
    fetch(`${apiUrl}/${id}`)
        .then(response => response.json())
        .then(student => {
            document.getElementById('firstName').value = student.firstName;
            document.getElementById('lastName').value = student.lastName;
            document.getElementById('yearOfStudy').value = student.yearOfStudy;
            document.getElementById('phoneNo').value = student.phoneNo;
            document.getElementById('email').value = student.email;
            document.getElementById('address').value = student.address;
            document.getElementById('electiveSub1').value = student.electiveSub1;
            document.getElementById('electiveSub2').value = student.electiveSub2;
            document.getElementById('cgpa1').value = student.cgpa1;
            document.getElementById('cgpa2').value = student.cgpa2;
            document.getElementById('cgpa3').value = student.cgpa3;
            document.getElementById('cgpa4').value = student.cgpa4;

            // Show update button
            document.getElementById('updateButton').style.display = 'inline-block';
            document.getElementById('updateStudentId').value = id; // Set the ID to updateStudentId input
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Update Student
function updateStudent(id) {
    const studentData = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        yearOfStudy: document.getElementById('yearOfStudy').value,
        phoneNo: document.getElementById('phoneNo').value,
        email: document.getElementById('email').value,
        address: document.getElementById('address').value,
        electiveSub1: document.getElementById('electiveSub1').value,
        electiveSub2: document.getElementById('electiveSub2').value,
        cgpa1: document.getElementById('cgpa1').value,
        cgpa2: document.getElementById('cgpa2').value,
        cgpa3: document.getElementById('cgpa3').value,
        cgpa4: document.getElementById('cgpa4').value
    };

    fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(studentData),
    })
    .then(response => {
        // Check if the response is OK
        if (response.ok) {
            return response.json(); // Parse JSON if successful
        } else {
            return response.json().then(errorData => {
                // Return error message
                throw new Error(errorData.message || 'Failed to update student. Please try again.');
            });
        }
    })
    .then(data => {
        alert('Student updated successfully!');
        document.getElementById('studentForm').reset();
        document.getElementById('updateButton').style.display = 'none';
        getAllStudents(); // Refresh student list after updating
    })
    .catch(error => {
        alert(error.message); // Show the error message in alert
        console.error('Error:', error); // Log error to console
    });
}

// Get Student by ID
function getStudentById() {
    const id = document.getElementById('studentId').value;

    fetch(`${apiUrl}/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Student not found');
            }
            return response.json();
        })
        .then(student => {
            document.getElementById('studentDetails').innerHTML = `
                <h3>Student Details:</h3>
                <p>ID: ${student.id}</p>
                <p>Name: ${student.firstName} ${student.lastName}</p>
                <p>Year of Study: ${student.yearOfStudy}</p>
                <p>Phone: ${student.phoneNo}</p>
                <p>Email: ${student.email}</p>
                <p>Address: ${student.address}</p>
                <p>Elective 1: ${student.electiveSub1}</p>
                <p>Elective 2: ${student.electiveSub2}</p>
                <p>CGPA: ${student.cgpa1} (FE), ${student.cgpa2} (SE), ${student.cgpa3} (TE), ${student.cgpa4} (BE)</p>
            `;
        })
        .catch(error => {
            document.getElementById('studentDetails').innerHTML = `<p>${error.message}</p>`;
        });
}

// Delete Student
function deleteStudent(id) {
    fetch(`${apiUrl}/${id}`, {
        method: 'DELETE',
    })
    .then(response => {
        if (response.ok) {
            alert('Student deleted successfully!');
            getAllStudents(); // Refresh student list after deleting
        } else {
            alert('Failed to delete student. Please try again.');
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

// Filter Students by Year of Study
function filterStudents() {
    const year = document.getElementById('filterYear').value;

    fetch(year ? `${apiUrl}/yearOfStudy${year}` : apiUrl)
        .then(response => response.json())
        .then(students => {
            displayStudents(students);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Initialize by fetching all students
getAllStudents();
