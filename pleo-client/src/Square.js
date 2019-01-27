import React from 'react';

export class Square extends React.Component {
    render() {
        const w = this.props.dims[0];
        const h = this.props.dims[1];
        let backGroundColor = 'white';
        if (this.props.contents === '') {
            backGroundColor = '#EB144C';
        } else if (this.props.contents === 'X') {
            backGroundColor = '#8ED1FC';
        }
        const style = {
            width: w,
            height: h,
            backgroundColor: backGroundColor,
            color: 'pink',
            border: "1px solid black",
            tableLayout: 'fixed',
        };

        return (
            <td
                style={style}
                onClick={this.props.onClick}
            >
            </td>
        )
    }
}