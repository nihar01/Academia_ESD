window.onload = fetch_courses;

async function fetch_courses() {
    // if (!sessionStorage.getItem('id')) {
    //     location.href = "index.html";
    //     return;
    // }
    let response = await fetch("api/courses/get");
    let courses = await response.json(); // read response body and parse as JSON
    console.log(courses);
    let table = document.getElementById("testBody");

    courses.forEach(courses => {
        let row = table.insertRow();
        let CourseID = row.insertCell(0);
        CourseID.innerHTML = courses['course_id'];

        let Name = row.insertCell(1);
        Name.innerHTML = courses['name'];

        let CourseCode = row.insertCell(2);
        CourseCode.innerHTML = courses['course_code'];

        let Description = row.insertCell(3);
        Description.innerHTML = courses['description'];
    });

    // courses_option.innerHTML = '<option value=""> Choose...</option>';
    //
    // for (let i = 0; i < courses.length; i++) {
    //     courses_option.innerHTML += '<option value="' + courses[i] + '">' + courses[i] + '</option>';
    // }
}