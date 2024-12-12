import React from 'react';

const LogPanel = ({ logs }) => {
  return (
    <div style={{ marginTop: "20px", textAlign: "left" }}>
      <h2>Logs:</h2>
      <textarea
        rows="10"
        cols="50"
        value={logs.join("\n")}
        readOnly
        style={{ width: "100%", height: "200px", backgroundColor: "#f9f9f9", border: "1px solid #ddd", padding: "10px" }}
      ></textarea>
    </div>
  );
};

export default LogPanel;