//import React from "react";
import './Dashboard.css';
import Header from '../../Components/Header/Header';

const Dashboard = () => {
    return (
        <div>
            <Header />
            <div className="mainBlock">
                <div className="dashboardContent">
                    <div className="discussoes">
                        <h2>Discussões</h2>
                    </div>
                    <div className="posts">
                        <h2>Postagens</h2>
                    </div>
                </div>
            </div>
        </div>

    );
};

export default Dashboard