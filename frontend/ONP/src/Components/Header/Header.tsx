import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { FaPlus, FaSearch, FaUserCircle } from 'react-icons/fa';
import './header.css'
import ProfileModal from '../ProfileModal/ProfileModal';
import PostagemModal from '../PostagemModal/PostagemModal';

const Header = () => {
    const [isProfileModalOpen, setIsProfileModalOpen] = useState(false);
    const [isPostagemModalOpen, setIsPostagemModalOpen] = useState(false);
    const navigate = useNavigate();

    const handlePostagemModal = () => {
        setIsPostagemModalOpen((prev) => !prev);
    }

    const handleProfileModal = () => {
        setIsProfileModalOpen((prev) => !prev);
    }

    const handleSearch = () => {
        navigate('/Search')
    }

    const handleDashboard = () => {
        navigate('/')
    }

    return (
        <div className="header">
            <h1 className='title' onClick={handleDashboard}>DCyber</h1>
            <div className="search-container">
                <input type='text' placeholder=' Pesquisar postagens e discussões' className='searchbar'></input>
                <FaSearch onClick={handleSearch} />
            </div>
            <div className="postDiv">
                <FaPlus onClick={handlePostagemModal} className='postOpen' size={30} color='333'/>
                <PostagemModal isOpen={isPostagemModalOpen} onClose={handlePostagemModal}/>
            </div>
            
            <div className="profileDiv">
                <FaUserCircle onClick={handleProfileModal} className='profilePic' size={30} color='#333'/>
                <ProfileModal isOpen={isProfileModalOpen} onClose={handleProfileModal} />
            </div>
          
        </div>
    )
}

export default Header;