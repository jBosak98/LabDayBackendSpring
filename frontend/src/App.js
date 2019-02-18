import React, { Component } from 'react';
import './styles/App.css';
import Header from './components/Header';
import { LoginForm } from './components/LoginForm';
import { Router, Route } from "react-router-dom";
import { Dashboard } from './components/Dashboard';
import BugForm  from './components/BugForm';
import { connect } from 'react-redux';
import {PrivateRoute} from "./services/PrivateRoute";
import {alertActions} from "./actions/alertActions";
import { history } from "./helpers/history";
import {Logout} from "./components/Logout";

class App extends Component {

  constructor(props){
    super(props);
    const { dispatch } = this.props;
    history.listen((location, action) => {
      dispatch(alertActions.clear());
    })
  }

  onLogout(e){

  }
  render() {
    return (
      <Router history = { history }>
        <div className="App">
          <Header />
            <PrivateRoute exact path="/" component={Dashboard} />
            <Route exact path="/login" component={LoginForm} />
            <Route exact path="/bug" component={BugForm} />
            <Route exact path="/logout" component={Logout}/>
        </div>
      </Router>
    );
  }
}

function mapStateToProps(state) {
    const { alert } = state;
    return { alert };
}

const connectedApp = connect(mapStateToProps)(App)
export { connectedApp as App };