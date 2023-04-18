import React, { useState } from "react";

export default function AddCar() {

    const [formData, setFormData] = useState({
       car_id: "", 
       brand: "",
       model: "",
       category_id: ""
    });

    const [formSubmitted, setFormSubmitted] = useState(false);

    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        let requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(formData),
            redirect: 'follow'
        };

        fetch('https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/car/car', requestOptions)
        .then((response) => response.json())
        .then((data) => {
            console.log(data)
            setFormSubmitted(true);
        }) .catch((error) => {
            console.log(error);
        });
    }
    

    return(
        <React.Fragment>
            <form 
                method="POST" 
                action="https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/car/car"
                onSubmit={handleSubmit}
            >
                <label>
                    Id:
                    <input 
                        type="number"
                        name="car_id"
                        value={formData.car_id}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Brand:
                    <input 
                        type="text"
                        name="brand"
                        value={formData.brand}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Model:
                    <input 
                        type="number"
                        name="model"
                        value={formData.model}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Category:
                    <input 
                        type="number"
                        name="category_id"
                        value={formData.category_id}
                        onChange={handleInputChange}
                    />
                </label>

                <button type="submit">Submit</button>
                {formSubmitted ? <p>Reload page</p> : null}
            </form>
        </React.Fragment>
    );
};