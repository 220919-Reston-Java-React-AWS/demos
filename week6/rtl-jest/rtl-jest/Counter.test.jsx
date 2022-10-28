import { render, screen } from "@testing-library/react"
import { act } from "react-dom/test-utils"

import Counter from "./Counter"


test('Count should increment by 1 after clicking', () => {
    //Render component using RTL
    render(<Counter />);

    const p = document.querySelector('p');
    const button = document.querySelector("button");

    //Starts at 0
    expect(p?.innerHTML).toBe("0");

    //Click button
    act(() => {
        button?.dispatchEvent(new MouseEvent('click', { bubbles: true }))
    })

    //Test that it should be 1
    expect(p?.innerHTML).toBe('1')

})