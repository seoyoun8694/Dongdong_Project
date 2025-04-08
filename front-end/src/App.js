import React, { useEffect, useState } from 'react';
import KakaoMap from './components/KakaoMap';

function App() {
    const [vendors, setVendors] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/vendors")
            .then(res => res.json())
            .then(data => setVendors(data))
            .catch(err => console.error(err));
    }, []);

    return (
        <div>
            <h1>노점 지도</h1>
            <KakaoMap vendors={vendors} />
        </div>
    );
}

export default App;