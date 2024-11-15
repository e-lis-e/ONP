//import React from 'react'
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Dashboard from './Pages/Dashboard/Dashboard';
import LoginScreen from './Pages/Login/LoginScreen';
import './App.css'
import RegisterScreen from './Pages/Register/RegisterScreen';
import Perfil from './Pages/Perfil/Perfil';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/Dashboard" element={<Dashboard/>} />
                <Route path='/Login' element={<LoginScreen/>}/>
                <Route path='/Register' element={<RegisterScreen/>}/>
                <Route path='/Profile' element={<Perfil/>}/>
            </Routes>
        </Router>

    );
};

export default App
