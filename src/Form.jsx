import React, { useState } from 'react';
import axios from 'axios';

const Form = ({ setLogs }) => {
  const [ticketPoolMaxCapacity, setTicketPoolMaxCapacity] = useState('');
  const [totalTickets, setTotalTickets] = useState('');
  const [releaseRate, setReleaseRate] = useState('');
  const [retrievalRate, setRetrievalRate] = useState('');
  const [quantity, setQuantity] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    const data = {
      ticketPoolMaxCapacity,
      totalTickets,
      releaseRate,
      retrievalRate,
      quantity,
    };

    try {
        const response = await axios.post('http://localhost:8080/api/tickets/processEvent', data);
      setLogs((prevLogs) => [...prevLogs, 'Simulation started: ' + response.data.message]);
    } catch (error) {
      console.error('Error starting simulation:', error);
      setLogs((prevLogs) => [...prevLogs, 'Error starting simulation.']);
    }
  };

  const handleStop = async () => {
    try {
      const response = await axios.post('http://localhost:8080/api/tickets/stop');
      setLogs((prevLogs) => [...prevLogs, 'Simulation stopped: ' + response.data.message]);
    } catch (error) {
      console.error('Error stopping simulation:', error);
      setLogs((prevLogs) => [...prevLogs, 'Error stopping simulation.']);
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>
          Ticket Pool Max Capacity:
          <input
            type="number"
            value={ticketPoolMaxCapacity}
            onChange={(event) => setTicketPoolMaxCapacity(event.target.value)}
          />
        </label>
        <br />
        <label>
          Total Tickets:
          <input
            type="number"
            value={totalTickets}
            onChange={(event) => setTotalTickets(event.target.value)}
          />
        </label>
        <br />
        <label>
          Release Rate (seconds):
          <input
            type="number"
            value={releaseRate}
            onChange={(event) => setReleaseRate(event.target.value)}
          />
        </label>
        <br />
        <label>
          Retrieval Rate (seconds):
          <input
            type="number"
            value={retrievalRate}
            onChange={(event) => setRetrievalRate(event.target.value)}
          />
        </label>
        <br />
        <label>
          Quantity Per Customer:
          <input
            type="number"
            value={quantity}
            onChange={(event) => setQuantity(event.target.value)}
          />
        </label>
        <br />
        <button type="submit">Start Simulation</button>
        <button type="button" onClick={handleStop}>
          Stop Simulation
        </button>
      </form>
    </div>
  );
};

export default Form;