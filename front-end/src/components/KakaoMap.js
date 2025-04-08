import React, { useEffect } from "react";

const KakaoMap = ({ vendors }) => {
    useEffect(() => {
        const loadScript = () => {
            const script = document.createElement("script");
            script.src = `https://dapi.kakao.com/v2/maps/sdk.js?appkey=${process.env.REACT_APP_KAKAO_API_KEY}&autoload=false&libraries=services`;
            script.async = true;
            script.onload = () => {
                window.kakao.maps.load(() => {
                    const container = document.getElementById("map");
                    const options = {
                        center: new window.kakao.maps.LatLng(37.580178, 127.046835),
                        level: 5,
                    };
                    const map = new window.kakao.maps.Map(container, options);

                    const geocoder = new window.kakao.maps.services.Geocoder();

                    vendors.forEach(vendor => {
                        const fullAddress = `서울특별시 동대문구 ${vendor.address}`;

                        geocoder.addressSearch(fullAddress, (result, status) => {
                            if (status === window.kakao.maps.services.Status.OK) {
                                const coords = new window.kakao.maps.LatLng(result[0].y, result[0].x);
                                new window.kakao.maps.Marker({ map, position: coords });
                            } else {
                                console.error("주소 검색 실패:", status);
                            }
                        });
                    });
                });
            };
            document.head.appendChild(script);
        };

        if (!window.kakao || !window.kakao.maps) {
            loadScript();
        } else {
            window.kakao.maps.load(() => { });
        }
    }, [vendors]);

    return <div id="map" style={{ width: "100%", height: "400px" }} />;
};

export default KakaoMap;