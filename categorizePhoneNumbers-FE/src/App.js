import React from "react";
import { Switch, Route } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "@fortawesome/fontawesome-free/css/all.css";
import "@fortawesome/fontawesome-free/js/all.js";
import "./App.css";

import CustomerList from "./components/CustomerList";

function App() {
  return (
    <div>
      <div className="container mt-3">
        <Switch>
          <Route exact path={["/", "/customers"]} component={CustomerList} />
        </Switch>
      </div>
    </div>
  );
}

export default App;
