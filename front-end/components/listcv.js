import * as React from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import deleteCVById from '../lib/deleteCVById';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import Link from 'next/link';
import {ListItemButton} from "@mui/material";

const handleDelete = async (id) => {
    const resp = await deleteCVById(id);
    console.log(resp);
}
export default function ListCV({ data }) {
    return (
        <List >
            {data.map(({ id, username, attachment }) => (
                <div key={id}>
                <Link href={`/cv?id=${id}`} passHref>
                    <ListItem alignItems="center" sx={{ backgroundColor : '#ededed', borderRadius : '4px'}}>
                        <ListItemButton>
                        <ListItemAvatar>
                            <Avatar {...stringAvatar(username)} />
                        </ListItemAvatar>
                        <ListItemText
                            primary={<Typography sx={{ color: '#080061', fontWeight: 'bold' }}>{username}</Typography>}
                            secondary={
                                <React.Fragment>
                                    <Typography
                                        sx={{ display: 'inline' }}
                                        component="span"
                                        variant="body1"
                                        color="text.primary"
                                    >
                                        Description :
                                    </Typography>
                                    {attachment.content.slice(0, 200)} ...
                                </React.Fragment>
                            }
                        />
                        </ListItemButton>
                    </ListItem>
                </Link>
                <Button sx={{color : '#D80032', marginLeft : '8px' }} onClick={() => handleDelete(id)} startIcon={<DeleteIcon />}>
                            Delete
                </Button>
                <Divider variant="inset" component="hr" sx={{ marginY: '6px', borderColor: '#080061' }} />
                </div>
            ))}
        </List>
    )
}

function stringToColor(string) {
    let hash = 0;
    let i;
    for (i = 0; i < string.length; i += 1) {
        hash = string.charCodeAt(i) + ((hash << 5) - hash);
    }

    let color = '#';

    for (i = 0; i < 3; i += 1) {
        const value = (hash >> (i * 8)) & 0xff;
        color += `00${value.toString(16)}`.substr(-2);
    }
    return color;
}

function stringAvatar(name) {
    return {
        sx: {
            bgcolor: stringToColor(name),
        },
        children: `${name.split(' ')[0][0]}${name.split(' ')[1][0]}`,
    };
}