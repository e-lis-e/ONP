import React from "react";
import { useNavigate } from "react-router-dom";
import "./ProfileModal.css";

interface ProfileModalProps {
    isOpen: boolean;
    onClose: () => void;
}

const ProfileModal: React.FC<ProfileModalProps> = ({ isOpen, onClose }) => {
    const navigate = useNavigate();

    if (!isOpen) return null;

    return (
        <div className="profileModal" onClick={onClose}>
            <div className="profileModalContent" onClick={(e) => e.stopPropagation()}>
                <a className="profileOption" onClick={() => navigate("/Profile")}>
                    Editar Perfil
                </a>
                <a className="profileOption" onClick={() => navigate("/Login")}>
                    Sair
                </a>
            </div>
        </div>
    );
};

export default ProfileModal;
