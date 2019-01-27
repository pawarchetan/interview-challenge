import React, {Component} from 'react';
import {Square} from './Square';
import './App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            dim: 5,
            grid: Array(5).fill(0).map(() => Array(5).fill("+")),
            waterContainedCells: null,
            winner: null,
            active: true,
            arr: Array(5).fill(0),
            totalUnitsOfWaterContained: 0
        };

        this.handleOnClick = this.handleOnClick.bind(this);
        this.rain = this.rain.bind(this);
        this.handleReset = this.handleReset.bind(this);
        this.dims = [parseFloat(180 / this.state.grid.length), parseFloat(180 / this.state.grid[0].length)]
    }

    handleReset() {
        const newGrid = Array(this.state.dim).fill(0).map(() => Array(this.state.dim).fill("+"));
        this.setState({'grid': newGrid, arr: Array(this.state.dim).fill(0)});
        this.setState({totalUnitsOfWaterContained: 0});
    }

    displayWaterGrid() {
        this.setState({totalUnitsOfWaterContained: this.state.waterContainedCells.totalUnitsOfWaterContained});
        let temp = this.state.waterContainedCells.waterContainedCells;
        if (temp === undefined) {
            alert(this.state.waterContainedCells.message);
            return;
        }
        if (this.state.totalUnitsOfWaterContained === 0) {
            alert("given cells do not form container... sorry i cant help you without container !!")
        }
        const waterGrid = this.state.grid;
        for (let y = 0; y < temp.length; y++) {
            if (temp[y] !== 0) {
                let v = temp[y];
                for (let x = this.state.dim - 1; x >= 0; x--) {
                    if (waterGrid[x][y] === '+' && v !== 0) {
                        waterGrid[x][y] = 'X';
                        v--;
                    }
                }
            }
        }

        this.setState({'grid': waterGrid});
    }

    rain() {
        let uri = 'http://localhost:8080/watercontainer/api/v1/units?height=';
        for (let i = 0; i < this.state.arr.length; i++) {
            if (i === this.state.arr.length - 1) {
                uri = uri + this.state.arr[i]
            } else {
                uri = uri + this.state.arr[i] + '&height='
            }
        }
        console.log('----->' + uri);
        fetch(uri)
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({
                        isLoaded: true,
                        waterContainedCells: result
                    });
                    this.displayWaterGrid();
                },
                (error) => {
                    this.setState({
                        isLoaded: true,
                        error
                    });
                }
            )
    }

    handleOnClick(x, y) {
        const g = this.state.grid;
        this.state.arr[y] = this.state.dim - x;
        if (this.state.active) {
            if (g[x][y] === '+') {
                g[x][y] = '';
                for (let i = 1; i <= this.state.dim - x - 1; i++) {
                    g[x + i][y] = '';
                }
                this.setState({'grid': g});
            } else {
                alert('Please select correct cell!');
            }
        }
    }

    render() {
        const style = {
            margin: 'auto',
            width: "auto",
            height: "auto",
            backgroundColor: 'white',
            color: 'white',
            fontSize: "3em",
            tableLayout: 'fixed',
        }
        const rows = this.state.grid.map((r, i) => {
                return (
                    <tr key={"row_" + i}>
                        {r.map((d, j) => {
                                return (
                                    <Square
                                        key={i + "_" + j}
                                        dims={this.dims}
                                        onClick={() => {
                                            this.handleOnClick(i, j)
                                        }}
                                        contents={d}/>
                                )
                            }
                        )
                        }
                    </tr>)
            }
        );
        return (
            <div style={{textAlign: "center"}}>
                <h1>Pleo Challenge</h1>
                <small><h3>Note:</h3> To increase or reduce number of rows please use '+/-' buttons and apply changes using 'Reset/Apply'
                    button.
                </small>
                <br/><br/>
                <table cellSpacing="0" id="table" style={style}>
                    <tbody>
                    {rows}
                    </tbody>
                </table>
                <br/><br/>
                <h2>Total units of water contained in all basins : {this.state.totalUnitsOfWaterContained}</h2>
                <button style={{margin: "auto"}} onClick={this.handleReset}>Reset/Apply</button>
                <button style={{margin: "auto"}} onClick={this.rain}>Rain</button>
                <br/><br/>
                <button onClick={() => {
                    this.setState({dim: this.state.dim - 1});
                }}>-
                </button>

                &nbsp;&nbsp;&nbsp;<span style={{color: 'black'}}>{this.state.dim}</span>&nbsp;&nbsp;&nbsp;

                <button onClick={() => {
                    this.setState({dim: this.state.dim + 1});
                }}>+
                </button>
                <br/><br/><br/>
            </div>
        )
    }
}

export default App;
