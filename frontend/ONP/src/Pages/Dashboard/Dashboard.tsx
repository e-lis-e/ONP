//import React from "react";
import './Dashboard.css';
import Header from '../../Components/Header/Header';
import { useEffect, useState } from 'react';

const Dashboard = () => {
    // const [discussoes, setDiscussoes] = useState([]);
    const [postagens, setPostagens] = useState([]);

    useEffect(() => {
        
        fetch('/api/postagens')
        .then((res) => res.json())
        .then((data: InstanceType<typeof postagens>[]) => setPostagens(data))
        .catch((error) => console.error('Erro ao buscar postagens:', error));
    }, []);

    return (
        <div className='dashboard'>
            <div className="container">
            <Header />
                <div className="dashboardContent">
                    <div className="discussoes">
                        <h2>Discussões</h2>
                         {postagens.length > 0 ? (
                            <ul>
                                {postagens.map((discussao) => (
                                    <li key={post.postagem_id}>{post.titulo}</li>
                                ))}
                            </ul>
                        ) : (
                            <p>Nenhuma discussão encontrada</p>
                        )}
                    </div>
                    <div className="posts">
                        <h2>Postagens</h2>
                        {postagens.length > 0 ? (
                            <ul>
                                {postagens.map((post) => (
                                    <li key={post.postagem_id}>{post.titulo} - <span>{post.usuario?.nome}</span></li>
                                ))}
                            </ul>
                        ) : (
                            <p>Nenhuma postagem encontrada</p>
                        )}
                    </div>
                </div>
            </div>
        </div>

    );
};

export default Dashboard