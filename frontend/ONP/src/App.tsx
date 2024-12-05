//import React from 'react'
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Dashboard from './Pages/Dashboard/Dashboard';
import LoginScreen from './Pages/Login/LoginScreen';
import './App.css'
import RegisterScreen from './Pages/Register/RegisterScreen';
import Perfil from './Pages/Perfil/Perfil';
import SearchPage from './Pages/Search/SearchPage';
import PostagemScreen from './Pages/Postagem/PostagemScreen';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Dashboard/>} />
                <Route path='/Login' element={<LoginScreen/>}/>
                <Route path='/Register' element={<RegisterScreen/>}/>
                <Route path='/Profile' element={<Perfil/>}/>
                <Route path='/Search' element={<SearchPage/>}/>
                <Route path="/postagem/:postagem_id" element={<PostagemScreen/>} />
            </Routes>
        </Router>

    );
};

export default App
