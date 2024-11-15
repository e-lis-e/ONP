//import React from 'react';
import { useNavigate } from 'react-router-dom';
import { FaUserCircle } from 'react-icons/fa';
import './header.css'

const Header = () => {
    const navigate = useNavigate();

    const handleProfile = () => {
        navigate('/Perfil');
    };

    return (
        <div className="header">
            <h1 className='title'>DCyber</h1>
            <input type='text' placeholder='Pesquisar postagens e discussões' className='searchbar'></input>
            <FaUserCircle onClick={handleProfile} className='profilePic' size={30} color='#007bff'/>
        </div>
    )
}

export default Header;