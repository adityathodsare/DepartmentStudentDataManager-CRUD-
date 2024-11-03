# DepartmentStudentDataManager-CRUD-
This Spring Boot project is designed to manage student information through a RESTful API.
Functionality Provided:
Create a Student (@PostMapping):

Adds a new student record to the database.
Endpoint: POST /api/students
Accepts a studentDto object and returns the saved student data with HTTP status 201 CREATED.
Get Student by ID (@GetMapping("{id}")):

Retrieves the details of a student by their ID.
Endpoint: GET /api/students/{id}
Returns a studentDto object if found.
Get All Students (@GetMapping):

Fetches the list of all students.
Endpoint: GET /api/students
Returns a list of studentDto objects.
Update Student Information (@PutMapping("{id}")):

Updates the information of an existing student based on their ID.
Endpoint: PUT /api/students/{id}
Accepts updated studentDto data and returns the modified record.
Delete Student (@DeleteMapping("{id}")):

Deletes a student record by ID.
Endpoint: DELETE /api/students/{id}
Returns a confirmation message.
Fetch Students by Year of Study:

First-Year (FE): Endpoint GET /api/students/yearOfStudyFE
Second-Year (SE): Endpoint GET /api/students/yearOfStudySE
Third-Year (TE): Endpoint GET /api/students/yearOfStudyTE
Fourth-Year (BE): Endpoint GET /api/students/yearOfStudyBE
These methods return lists of student entities filtered by the year of study.
