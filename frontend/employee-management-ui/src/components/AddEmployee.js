import React, { useState } from 'react';
import axios from 'axios';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const AddEmployee = ({ onEmployeeAdded }) => {
  const [employee, setEmployee] = useState({
    firstName: '',
    lastName: '',
    email: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployee({ ...employee, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { firstName, lastName, email } = employee;

    if (!firstName || !lastName || !email) {
      toast.error("All fields are required");
      return;
    }

    try {
      await axios.post("http://localhost:8080/api/employees", employee);
      toast.success("Employee added successfully!");
      setEmployee({ firstName: '', lastName: '', email: '' });
      onEmployeeAdded();
    } catch (err) {
      console.error("Error adding employee:", err);
      toast.error("Failed to add employee.");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Add Employee</h2>
      <form onSubmit={handleSubmit}>
        <input
          name="firstName"
          placeholder="First Name"
          value={employee.firstName}
          onChange={handleChange}
        />
        <input
          name="lastName"
          placeholder="Last Name"
          value={employee.lastName}
          onChange={handleChange}
        />
        <input
          name="email"
          placeholder="Email"
          type="email"
          value={employee.email}
          onChange={handleChange}
        />
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddEmployee;
