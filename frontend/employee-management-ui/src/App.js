import React, { useState } from 'react';
import Header from './components/Header';
import EmployeeList from './components/EmployeeList';
import AddEmployee from './components/AddEmployee';
import { ToastContainer } from 'react-toastify';

function App() {
  const [refresh, setRefresh] = useState(false);

  const handleEmployeeAdded = () => {
    setRefresh(prev => !prev);
  };

  return (
    <div className="App">
      <Header />
      <AddEmployee onEmployeeAdded={handleEmployeeAdded} />
      <EmployeeList refresh={refresh} />
      <ToastContainer position="top-center" autoClose={3000} />
    </div>
  );
}

export default App;
