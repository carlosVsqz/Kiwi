import React from 'react';
import Link from 'next/link';
import {PostItem} from '@store/slices/posts';

const PostCoverImage = ({ data }: { data: PostItem }) => {
  return (
    <Link href="/p/[id]" as={'/p/' + data.id}>
      <a href={'/p/' + data.id} className="card-cover">
        <img src={data.image as string} alt="card cover" />
      </a>
    </Link>
  );
};
export default PostCoverImage;
