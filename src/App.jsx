import React, { useState } from 'react';
import Form from './Form';
import LogPanel from './logPanel';

const App = () => {
  const [logs, setLogs] = useState([]);

  return (
    <div style={{ textAlign: "center", margin: "20px" }}>
      <h1>Ticket Simulation</h1>
      <Form setLogs={setLogs} />
      <LogPanel logs={logs} />
    </div>
  );
};

export default App;