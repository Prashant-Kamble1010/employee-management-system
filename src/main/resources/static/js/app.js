const API_URL="http://localhost:8080/api/employees";

window.onload=loadEmployees;

function loadEmployees(){

fetch(API_URL)
.then(res=>res.json())
.then(data=>{

let rows="";

data.forEach(emp=>{

rows+=`
<tr>
<td>${emp.id}</td>
<td>${emp.name}</td>
<td>${emp.email}</td>
<td>${emp.department}</td>
<td>${emp.salary}</td>

<td>

<button class="edit-btn"
onclick="editEmployee(${emp.id})">
Edit
</button>

<button class="delete-btn"
onclick="deleteEmployee(${emp.id})">
Delete
</button>

</td>

</tr>
`;

});

document.getElementById("employeeTable").innerHTML=rows;

});

}

function saveEmployee(){

let id=document.getElementById("employeeId").value;

let employee={

name:document.getElementById("name").value,
email:document.getElementById("email").value,
department:document.getElementById("department").value,
salary:document.getElementById("salary").value

};

if(id){

fetch(API_URL+"/"+id,{
method:"PUT",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(employee)
})
.then(()=>loadEmployees());

}else{

fetch(API_URL,{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify(employee)
})
.then(()=>loadEmployees());

}

clearForm();

}

function editEmployee(id){

fetch(API_URL+"/"+id)
.then(res=>res.json())
.then(emp=>{

document.getElementById("employeeId").value=emp.id;
document.getElementById("name").value=emp.name;
document.getElementById("email").value=emp.email;
document.getElementById("department").value=emp.department;
document.getElementById("salary").value=emp.salary;

});

}

function deleteEmployee(id){

fetch(API_URL+"/"+id,{
method:"DELETE"
})
.then(()=>loadEmployees());

}

function clearForm(){

document.getElementById("employeeId").value="";
document.getElementById("name").value="";
document.getElementById("email").value="";
document.getElementById("department").value="";
document.getElementById("salary").value="";

}